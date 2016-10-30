baymaxPiApp.config(function ($stateProvider, $urlRouterProvider, USER_ROLES) {
  $stateProvider
    .state('login', {
      url: '/login',
      templateUrl: 'templates/login.html',
      controller: 'LoginCtrl'
    })
      .state('registro', {
        url: '/registro',
        templateUrl: 'templates/registro.html',
        controller: 'RegCtrl'
      })
    .state('main', {
      url: '/',
      abstract: true,
      templateUrl: 'templates/main.html'
    })
    .state('main.dash', {
      url: 'main/dash',
      views: {
        'dash-tab': {
          templateUrl: 'templates/dashboard.html',
          controller: 'DashCtrl'
        }
      }
    })
    .state('main.paciente', {
      url: 'main/paciente',
      views: {
        'paciente-tab': {
          templateUrl: 'templates/paciente.html'
        }
      }
    })
    .state('main.admin', {
      url: 'main/admin',
      views: {
        'admin-tab': {
          templateUrl: 'templates/admin.html'
        }
      },
      data: {
        authorizedRoles: [USER_ROLES.admin]
      }
    });

  // Thanks to Ben Noblet!
  $urlRouterProvider.otherwise(function ($injector, $location) {
    var $state = $injector.get("$state");
    $state.go("main.dash");
  });
})

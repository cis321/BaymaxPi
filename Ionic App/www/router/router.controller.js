/* globals baymaxPiApp */
baymaxPiApp.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'templates/login.html',
            controller: 'LoginCtrl',
        })
        .state('register', {
            url: '/registro',
            templateUrl: 'templates/componets/register/register.html',
            controller: 'RegCtrl',
        })
        .state('main', {
            url: '/',
            abstract: true,
            templateUrl: 'templates/main.html',
            controller: 'AppCtrl',
        })
        .state('main.dash', {
            url: 'main/dash',
            views: {
                'dash-tab': {
                    templateUrl: 'templates/componets/dashboard/dashboard.html',
                    controller: 'DashCtrl',
                },
            },
        })
        .state('main.paciente', {
            url: 'main/paciente',
            views: {
                'paciente-tab': {
                    templateUrl: 'templates/paciente.html',
                },
            },
        })
        .state('profile', {
            url: '/profile',
            templateUrl: 'templates/componets/profile/profile.html',
            controller: 'ProfileController',
        })

    .state('statistics', {
        url: '/statistics',
        templateUrl: 'templates/componets/statistics/statistics.html',
        controller: 'StadisticsCtrl',
    })

    .state('funcionario', {
        url: '/funcionario',
        templateUrl: 'templates/componets/funcionario/funcionario.html',
        controller: 'FuncionarioCtrl',
    })

    .state('main.admin', {
        url: 'main/admin',
        views: {
            'admin-tab': {
                templateUrl: 'templates/componets/admin/admin.html',
                controller: 'AdminController',
            },
        },
    });

    // Thanks to Ben Noblet!
    $urlRouterProvider.otherwise(function ($injector) {
        var $state = $injector.get('$state');
        $state.go('login');
    });
})

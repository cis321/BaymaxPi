/* globals baymaxPiApp */
baymaxPiApp.config(function ($stateProvider, $urlRouterProvider, USER_ROLES) {
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
        })

        .state('statistics', {
            url: '/statistics',
            templateUrl: 'templates/componets/statistics/statistics.html',
            controller: 'StadisticsCtrl',
        })

        .state('main.admin', {
            url: 'main/admin',
            views: {
                'admin-tab': {
                    templateUrl: 'templates/admin.html',
                },
            },
            data: {
                authorizedRoles: [USER_ROLES.admin, ],
            },
        });

    // Thanks to Ben Noblet!
    $urlRouterProvider.otherwise(function ($injector, $location) {
        var $state = $injector.get('$state');
        $state.go('login');
    });
})

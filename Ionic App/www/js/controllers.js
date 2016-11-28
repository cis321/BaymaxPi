angular.module('starter')

    .controller('AppCtrl', function ($scope, $state, $ionicPopup, AuthService, AUTH_EVENTS, StateService) {
        $scope.username = AuthService.username();

        $scope.data = StateService.get();

        $scope.$on(AUTH_EVENTS.notAuthorized, function (event) {
            var alertPopup = $ionicPopup.alert({
                title: 'Unauthorized!',
                template: 'You are not allowed to access this resource.',
            });
        });

        $scope.$on(AUTH_EVENTS.notAuthenticated, function (event) {
            AuthService.logout();
            $state.go('login');
            var alertPopup = $ionicPopup.alert({
                title: 'Session Lost!',
                template: 'Sorry, You have to login again.',
            });
        });

        $scope.setCurrentUsername = function (name) {
            $scope.username = name;
        };

        $scope.siEsMedico = function () {
            if(data.tipoUsuario === 'Médico')
            {
                return true;

            }
            else if(data.tipoUsuario === 'Paciente')
            {
                return false;

            }
        };
    })

/**    .controller('LoginCtrl', function($scope, $state, $http) {
  //conectarse a la red local (todos los dispositivos)
  var URL = "http://172.20.10.14:4000/m2m/applications/Central/containers/alarmContainer/contentInstances"
  $scope.LogIn = function() {
    var request = $http({
        method: "get",
        url: URL
      },
       headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
      });
      /*Successful HTTP post request or not */
/**      request.success(function (data){
        if (data == '1'){
          $scope.responseMessage = "You are in";
        }
        else {
          $scope.responseMessage = "Username or Password is incorrect";
        }
      })
  }
})*/


.controller('LoginCtrl', function($scope, $state, $ionicPopup, AuthService) {
    $scope.data = {};

    $scope.login = function(data) {
      AuthService.login(data.username, data.password).then(function(authenticated) {
        $state.go('main.dash', {}, {reload: true});
        $scope.setCurrentUsername(data.username);
      }, function(err) {
        var alertPopup = $ionicPopup.alert({
          title: 'Login failed!',
          template: 'Please check your credentials!'
        });
      });
    };
  })

    .controller('RegCtrl', function($scope, $state, $ionicPopup, AuthService) {
        $scope.data = {};

        $scope.registro = function(data) {
            $state.go('/registro', {}, {reload:true});
        };
    })


    .controller('DashCtrl', function($scope, $state, $http, $ionicPopup, AuthService) {
    $scope.logout = function() {
        AuthService.logout();
        $state.go('login');
    };

    $scope.performValidRequest = function () {
        $http.get('http://localhost:8100/valid').then(
            function (result) {
                $scope.response = result;
            });
    };

    $scope.performUnauthorizedRequest = function () {
        $http.get('http://localhost:8100/notauthorized').then(
            function (result) {
                // No result here..
            }, function (err) {
                $scope.response = err;
            });
    };

    $scope.performInvalidRequest = function () {
        $http.get('http://localhost:8100/notauthenticated').then(
            function (result) {
                // No result here..
            }, function (err) {
                $scope.response = err;
            });
    };
});

/* globals baymaxPiApp */
baymaxPiApp.controller('LoginCtrl', function ($scope, $state, $ionicPopup, LoginService, StateService) {
    $scope.data = {};

    $scope.login = function (data) {
        if (data.username === 'paciente' || data.username === 'medico') {
            $state.go('main.dash');
        } else if (data.username === 'funcionario') {
            $state.go('funcionario');
        } else {
            LoginService.login({
                username: data.username,
                contrasena: data.password,
            }, {}, loginSuccess, loginError);
        }
    }

    function loginSuccess (response) {
        StateService.set(response);

        if (response.disabled === false) {
          $state.go('main.dash');
        } else {
          $ionicPopup.alert({
              title: 'Error!',
              template: 'You don\'t have permissions yet!',
          });
        }
    }

    function loginError () {
        $ionicPopup.alert({
            title: 'Login failed!',
            template: 'Please check your credentials!',
        });
    }

    $scope.goRegister = function () {
        $state.go('register');
    };
})

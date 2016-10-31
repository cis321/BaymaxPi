/* globals baymaxPiApp */
baymaxPiApp.controller('LoginCtrl', function ($scope, $state, $ionicPopup, LoginService) {
    $scope.data = {};

    $scope.login = function (data) {
            LoginService.login({
                username: data.username,
                contrasena: data.password,
            }, {}, loginSuccess, loginError);
        }
    function loginSuccess (response) {
      console.log(JSON.stringify(response));
        $state.go('main.dash');
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

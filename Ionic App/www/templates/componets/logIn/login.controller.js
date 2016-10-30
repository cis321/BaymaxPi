/* globals baymaxPiApp */
baymaxPiApp.controller('LoginCtrl', function ($scope, $state, $ionicPopup, AuthService) {
    $scope.data = {};

    $scope.login = function (data) {
      AuthService.login(data.username, data.password).then(function (authenticated) {
        $state.go('main.dash', {}, {reload: true, });
        $scope.setCurrentUsername(data.username);
      }, function () {
        $ionicPopup.alert({
          title: 'Login failed!',
          template: 'Please check your credentials!',
        });
      });
    };

    $scope.goRegister = function () {
      $state.go('register');
    };
  })

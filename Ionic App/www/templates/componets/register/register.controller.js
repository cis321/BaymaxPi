/* globals baymaxPiApp */
baymaxPiApp.controller('RegCtrl', function ($scope, $state, LoginService, $ionicPopup) {
    $scope.data = {};

    $scope.createUser = function () {
      LoginService.createUser({}, $scope.data, createUserSuccess, createUserError);
    }

    function createUserSuccess () {
      $ionicPopup.alert({
        title: 'User creation succes!',
        template: 'Now you can login',
      });
      $state.go('login');
    }

    function createUserError (response) {
      $ionicPopup.alert({
        title: 'User creation faild!',
        template: 'Try later!',
      });
    }
})

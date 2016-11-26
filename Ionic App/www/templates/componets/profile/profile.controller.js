/* globals baymaxPiApp */
baymaxPiApp.controller('ProfileController', function ($scope, $state, StateService, $ionicHistory, LoginService, $ionicPopup) {
    $scope.data = StateService.get();
    $scope.isEditable = false;

    $scope.back = function () {
        $ionicHistory.goBack();
        $scope.isEditable = false;
    }

    $scope.isEditableSelected = function () {
        $scope.isEditable = true;
    }

    $scope.cancel = function () {
        $scope.isEditable = false;
    }

    $scope.updateUser = function () {
      delete $scope.data._id;
      LoginService.updateUser({}, $scope.data, createUserSuccess, createUserError);
    }

    function createUserSuccess () {
      $ionicPopup.alert({
        title: 'User update succes!',
        template: 'User update succes!',
      });
        $scope.isEditable = false;
    }

    function createUserError () {
      $ionicPopup.alert({
        title: 'User update faild!',
        template: 'Try later!',
      });
    }
})

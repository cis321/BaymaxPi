/* globals baymaxPiApp */
baymaxPiApp.controller('FuncionarioCtrl', function ($scope, $state, $ionicPopup, LoginService) {
    $scope.getAllDisabledMedics = function () {
        LoginService.getAllDisabledMedics({}, {}, getAllDisabledMedicsSuccess, getAllDisabledMedicsError)
    }

    $scope.getAllDisabledMedics();

    function getAllDisabledMedicsSuccess (response) {
        $scope.medicList = response;
    }

    function getAllDisabledMedicsError () {
        $ionicPopup.alert({
            title: 'Failed!',
            template: 'Error getting medic list!',
        });
    }

    $scope.updateMedic = function (medic) {
      medic.disabled = false;
      delete medic._id;
      LoginService.updateUser({}, medic, updateUserSuccess, updateUserError);
    }

    function updateUserSuccess () {
      $ionicPopup.alert({
          title: 'Success!',
          template: 'UserUpdated!',
      });
      $scope.getAllDisabledMedics();
    }

    function updateUserError () {
      $ionicPopup.alert({
          title: 'Failed!',
          template: 'Error updating medic!',
      });
    }
})

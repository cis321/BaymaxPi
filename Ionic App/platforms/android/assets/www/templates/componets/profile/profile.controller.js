/* globals baymaxPiApp */
baymaxPiApp.controller('ProfileController', function ($scope, $state, StateService, $ionicHistory) {
    $scope.data = StateService.get();

    $scope.isEditable = false;


    $scope.back = function()
    {
        $ionicHistory.goBack();
        $scope.isEditable = false;
    }

    $scope.isEditableSelected = function () {
        $scope.isEditable = true;
    }

    $scope.cancel = function () {
        $scope.isEditable = false;
    }
})

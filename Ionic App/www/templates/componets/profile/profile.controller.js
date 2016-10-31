/* globals baymaxPiApp */
baymaxPiApp.controller('ProfileController', function ($scope, $state, StateService) {
    $scope.data = StateService.get();
})

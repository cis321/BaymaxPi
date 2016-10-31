/* globals baymaxPiApp */
baymaxPiApp.controller('RegCtrl', function ($scope, $state, LoginService) {
    $scope.data = {};

    $scope.createUser = function () {
      LoginService.createUser({}, $scope.data, createUserSuccess, createUserError);
    }

    function createUserSuccess () {
      console.log(':)');
    }

    function createUserError (response) {
      console.log('error' + response);
    }
})

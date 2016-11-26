/* globals baymaxPiApp */
baymaxPiApp.controller('RegCtrl', function ($scope, $state, LoginService, $ionicPopup) {
    $scope.data = {};


    $scope.isMedico = false;
    $scope.isPaciente = false;

    $scope.createUser = function () {
        LoginService.createUser({}, $scope.data, createUserSuccess, createUserError);
    }

    $scope.isMedicoSelected = function () {
        $scope.isMedico = true;
        $scope.isPaciente = false;
    }

    $scope.isPacienteSelected = function () {
        $scope.isMedico = false;
        $scope.isPaciente = true;
    }

    function createUserSuccess () {
      $ionicPopup.alert({
        title: 'User creation succes!',
        template: 'Now you can login',
      });
      $state.go('login');
    }

    function createUserError () {
      $ionicPopup.alert({
        title: 'User creation faild!',
        template: 'Try later!',
      });
    }
})

/**
 * Created by ASUS on 30/10/2016.
 */
baymaxPiApp.controller('DashCtrl', function ($scope, $state, AuthService) {
    $scope.data = {};

    $scope.goProfile = function () {
        $state.go('profile');
    };

    $scope.goStatistics = function () {
        $state.go('statistics');
    };

    $scope.logout = function () {
       AuthService.logout();
       $state.go('login');
    };
})

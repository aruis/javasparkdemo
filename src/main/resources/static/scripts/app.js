/**
 * Created by liurui on 16/2/14.
 */
angular.module('app', [])
    .controller('LoginController', function ($scope, $http) {
        $scope.user = {}
        $scope.info = '欢迎登陆'

        //$http.get('/hello').then(function (res) {
        //    console.log(res)
        //    $scope.name = res.data;
        //})

        $scope.login = function () {
            console.log($scope.user)
            $http.post('/login', $scope.user).then(function (res) {

                console.log(res.data)

                if (res.status == 200) {
                    alert('登陆成功')
                }

            }, function (reason) {
                $scope.info = reason.data;
            })
        }
    });

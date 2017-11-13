'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
    .controller('LoginCtrl', function($window, $location, $scope, $http, $mdDialog, $rootScope, $cookieStore) {

        var vm = this;



        vm.acceptLogin = acceptLogin;
        vm.register = register;
        vm.errorDialog = errorDialog;


        vm.user;



        function register() {
            $location.path("/register");
        }


        function errorDialog() {


            var alert = $mdDialog.alert()
                .clickOutsideToClose(true)
                .title('Error')
                .textContent('Datos Incorrectos')
                .ariaLabel('Alert Dialog Demo')
                .ok('Aceptar');

            $mdDialog.show(alert).then(function() {
                $window.location.reload();
            });
        }



        function acceptLogin() {
            if (!angular.isUndefined(vm.user)) {
                if (!angular.isUndefined(vm.user.username) && !angular.isUndefined(vm.user.password)) {
                    if (vm.user.username !== '' && vm.user.password !== '') {
                        $http.get('http://andresolis-littlestark.c9users.io:8080/userLogin/' + vm.user.username + '/' + vm.user.password).then(function(response) {
                            console.log(response);
                            if (response.data[0].length === 1) {
                                $cookieStore.put('idUser', response.data[0][0].iduser);
                                var landingUrl = "http://" + $window.location.host + "/";
                                $window.location.href = landingUrl;
                            }
                            else {
                                vm.errorDialog();
                            }



                        });
                    }
                }
            }
            else{
                vm.errorDialog();
            }
        }




    });

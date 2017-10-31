'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
    .controller('RegisterCtrl', function($window, $scope, $http, $mdDialog) {

        var vm = this;


        
        vm.acceptLogin = acceptLogin;
     

        vm.user;






        function succesDialog() {


            var alert = $mdDialog.alert()
                .clickOutsideToClose(true)
                .title('Perfil Modificado')
                .textContent('Se ha modificado el perfil de manera exitosa')
                .ariaLabel('Alert Dialog Demo')
                .ok('Aceptar')

            $mdDialog.show(alert).then(function() {
                $window.location.reload();
            });
        };



        function acceptLogin() {
            if ((typeof(vm.user.username) !== "undefined") && (typeof(vm.user.password) !== "undefined") ) {
                if (vm.password2 === vm.user.password) {
                    vm.user.userType = vm.selectedUserType.value;
                    $http.post('http://andresolis-littlestark.c9users.io:8080/userRegister', vm.user).then(function(response) {

                    })

                }
            }
        }








    });
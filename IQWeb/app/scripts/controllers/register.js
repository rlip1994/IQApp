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


        vm.cancelRegister = cancelRegister;
        vm.acceptRegister = acceptRegister;
        vm.userTypes = [{ 'name': 'Administrador', 'value': 1 }, { 'name': 'Encuestador', 'value': 2 }];






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

        function cancelRegister() {
            console.dir(vm.user.userType);
        }



        function acceptRegister() {
            if ((typeof(vm.user.username) !== "undefined") && (typeof(vm.user.name) !== "undefined") && (typeof(vm.user.lastname1) !== "undefined") && (typeof(vm.user.email) !== "undefined") && (typeof(vm.user.password) !== "undefined") && (typeof(vm.password2) !== "undefined") && (typeof(vm.selectedUserType) !== "undefined")) {
                if (vm.password2 === vm.user.password) {
                    vm.user.userType = vm.selectedUserType.value;
                    $http.post('http://andresolis-littlestark.c9users.io:8080/userRegister', vm.user).then(function(response) {

                    })

                }
            }
        }








    });

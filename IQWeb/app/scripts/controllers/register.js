'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
    .controller('RegisterCtrl', function($window, $scope, $http, $mdDialog, $location) {

        var vm = this;

        vm.ErrorDialog = ErrorDialog;
        vm.cancelRegister = cancelRegister;
        vm.acceptRegister = acceptRegister;
        vm.loadUserTypes = loadUserTypes;
        vm.userTypes;

        vm.user;

        function cancelRegister() {
            $location.path("/login");
        }



        function acceptRegister() {
            if ((typeof(vm.user.username) !== "undefined") && (typeof(vm.user.name) !== "undefined") && (typeof(vm.user.lastname1) !== "undefined") && (typeof(vm.user.email) !== "undefined") && (typeof(vm.user.password) !== "undefined") && (typeof(vm.password2) !== "undefined") && (typeof(vm.selectedUserType) !== "undefined")) {
                if (vm.password2 === vm.user.password) {
                    vm.user.userType = vm.selectedUserType.iduserType;
                    console.dir(vm.user);
                    $http.post('http://andresolis-littlestark.c9users.io:8080/userRegister', vm.user).then(function(response) {
                        
                        console.dir(response);
                        if(response.data.affectedRows === 1){
                            $location.path('/login');
                        }
                        else{
                            vm.ErrorDialog();
                        }
                    });

                }
            }
        }


    function ErrorDialog() {
      
      $mdDialog.show(
        $mdDialog.alert()
          .clickOutsideToClose(true)
          .title('Error')
          .textContent('El nombre de cuenta ya existe')
          .ariaLabel('Alert Dialog Demo')
          .ok('Aceptar')
      );
    }

    function loadUserTypes(){
         $http.get('http://andresolis-littlestark.c9users.io:8080/getUsersTypes/').then(function (response) {
             console.log(response);
             vm.userTypes = response.data[0];
             
        });
    }



    });

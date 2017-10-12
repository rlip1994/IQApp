'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('ProfileCtrl', function ($window, $scope, $http, $mdDialog) {

    var vm = this;

    vm.editProfile = editProfile;
    vm.cancelUpdate = cancelUpdate;
    vm.acceptUpdate = acceptUpdate;
    vm.changePassword = changePassword;

    vm.start = start;


    vm.edit = true;
    vm.changePass = false;
    vm.passwordNew = false;
    vm.btnAcceptCancel = false;
    vm.user;




    function start() {
      $http.get('http://localhost:3000/userProfile/63').then(function (response) {

        $scope.vm.user = response.data[0][0];
      });
    }

    function editProfile() {
      vm.edit = false;
      vm.changePass = true;
      vm.btnAcceptCancel = !vm.edit;

      $http.get('http://localhost:3000/userProfile/63').then(function (response) {

        $scope.vm.user = response.data[0][0];
      });

    }

    function succesDialog() {


      var alert = $mdDialog.alert()
        .clickOutsideToClose(true)
        .title('Perfil Modificado')
        .textContent('Se ha modificado el perfil de manera exitosa')
        .ariaLabel('Alert Dialog Demo')
        .ok('Aceptar')

      $mdDialog.show(alert).then(function () {
        $window.location.reload();
      });
    };

    function cancelUpdate() {
      vm.edit = true;
      vm.btnAcceptCancel = !vm.edit;
      vm.passwordNew = !vm.edit;
      vm.passwordConfirm = !vm.edit;
    }

    function changePassword() {
      vm.passwordNew = !vm.passwordNew;
      vm.user.password = '';
    }

    function validUser() {
      return $http.get('http://localhost:3000/getValidUser/' + 63 + '/' + vm.user.password).then(function (response) {
        if (response.data[0][0]) {
          return response.data[0][0];
        }
      });
    }

    function doUpdate() {
      if (vm.passwordNew) {

        var prom = validUser();

        if (vm.passwordChange === vm.passwordConfirm) {
          vm.user.password = vm.passwordChange;
        }
        return prom.then(function (result) {
          if (result) {
            return $http.post('http://localhost:3000/userProfileMod', vm.user).then(function (response) {

              return response;

            })
          }
        });

      } else {
        return $http.post('http://localhost:3000/userProfileMod', vm.user).then(function (response) {

          return response;

        })
      }



    }

    function acceptUpdate() {

      var prom = doUpdate();
      var ok = prom.then(function (result) {
        if (result) {
          return true;
        }
      });
      if (ok) {
        succesDialog();

      }



    }




  }
  );

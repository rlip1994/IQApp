'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('ProfileCtrl', function () {
  

    this.editProfile=editProfile;
    this.cancelUpdate=cancelUpdate;


    this.edit=true;
    this.btnAcceptCancel=false;
    this.passwordNew = false;
    this.passwordConfirm = false;
    

    

    function editProfile(){
      this.edit = false;
      this.btnAcceptCancel = !this.edit;
      this.passwordNew = !this.edit;
      this.passwordConfirm = !this.edit;
      
    }

    function cancelUpdate(){
      this.edit = true;
      this.btnAcceptCancel = !this.edit;
      this.passwordNew = !this.edit;
      this.passwordConfirm = !this.edit;
    }



  });

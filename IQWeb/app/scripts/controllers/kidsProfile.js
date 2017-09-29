'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('kidsProfileCtrl', function () {
  

   this.updateKidsForm = updateKidsForm;
   this.cancelUpdate = cancelUpdate;


    this.edit=true;
    this.btnAcceptCancel=false;
  

    
    function updateKidsForm(){
      this.edit= false;
      this.btnAcceptCancel = !this.edit;
    }
    
    function cancelUpdate(){
      this.edit = true;
      this.btnAcceptCancel = !this.edit;
    }

   

  });

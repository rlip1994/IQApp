'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('kidsProfileCtrl', function ($scope,$http,$routeParams) {
  

   this.updateKidsForm = updateKidsForm;
   this.cancelUpdate = cancelUpdate;
   this.loadRegions = loadRegions;
   this.start=start;
   this.getkid;
   this.getCountry;
  this.selectedCountry;

    this.edit=true;
    this.btnAcceptCancel=false;

  
    function start(){
      
      $http.get('http://localhost:3000/getKid/'+$routeParams.idkid).then(function(response){
      $scope.vm.getkid=response.data[0][0];
      });
      this.selectedCountry=this.getkid.country;

    }
    
    function updateKidsForm(){
      this.edit= false;
      this.btnAcceptCancel = !this.edit;

      $http.get('http://localhost:3000/getCountry/').then(function(response){
        console.dir(response.data[0]);  
        $scope.vm.getCountry=response.data[0];
        });

    }

    function loadRegions(){
      if(this.selectedCountry){
        console.dir(this.selectedCountry);
      }
     
    }
    
    function cancelUpdate(){
      this.edit = true;
      this.btnAcceptCancel = !this.edit;
    }

   

  });

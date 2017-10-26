'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('kidsProfileCtrl', function ($scope,$http,$routeParams,$mdDialog,$window) {
  
   var vm = this;
   
   vm.updateKidsForm = updateKidsForm;
   vm.cancelUpdate = cancelUpdate;
   vm.acceptUpdate = acceptUpdate;
   vm.loadRegions = loadRegions;
   vm.loadCities = loadCities;
   vm.start=start;
   vm.getkid;
   vm.getCountry;
   vm.getRegions;
   vm.getCity;
   vm.getGrades;
   vm.getSchool;

   vm.edit=true;
   vm.btnAcceptCancel=false;

  
    function start(){
      
      $http.get('http://localhost:3000/getKid/'+$routeParams.idkid).then(function(response){
      vm.getkid=response.data[0][0];
      });
      

    }
    
    function updateKidsForm(){
      vm.edit= false;
      vm.btnAcceptCancel = !vm.edit;
     
      
      $http.get('http://localhost:3000/getCountry/').then(function(response){
         
        $scope.vm.getCountry=response.data[0];
        
        });

      $http.get('http://localhost:3000/getGrades/').then(function(response){
          
         $scope.vm.getGrades=response.data[0];

         });

      $http.get('http://localhost:3000/getSchool/').then(function(response){
        
         $scope.vm.getSchool=response.data[0];
         });

    }

    function loadRegions(){

      if(vm.selectedCountry){
 
        $http.get('http://localhost:3000/getRegions/'+vm.selectedCountry.idCountry).then(function(response){
     
           $scope.vm.getRegions=response.data[0];
           
        });
      }
     
    }

    function loadCities(){
      if(vm.selectedRegion){

        $http.get('http://localhost:3000/getCities/'+vm.selectedRegion.idRegion).then(function(response){
      
           $scope.vm.getCities=response.data[0];
        });
      }
     
    }
    
    function succesDialog() {
      
      $mdDialog.show(
        $mdDialog.alert()
          .clickOutsideToClose(true)
          .title('Niño modificado')
          .textContent('Se ha modificado un(a) niño(a) de manera exitosa')
          .ariaLabel('Alert Dialog Demo')
          .ok('Aceptar')
      );
    };

    function acceptUpdate(){
      
      vm.getkid.country=vm.selectedCountry.name;
      vm.getkid.region=vm.selectedRegion.name;
      vm.getkid.city=vm.selectedCity.idCity;
      vm.getkid.grade=vm.selectedGrade.idGrade;
      vm.getkid.school=vm.selectedSchool.idSchool;
      

      $http.post('http://localhost:3000/modKid',vm.getkid).then(function(response){
        console.log(response.data);
      });

      // validacion del contenido de getkid  que no sea NULL  
      succesDialog();
      var landingUrl = "http://" + $window.location.host + "/#!/kids";
      $window.location.href = landingUrl;
     
    }

    function cancelUpdate(){
      vm.edit = true;
      vm.btnAcceptCancel = !this.edit;
    }

   

  });

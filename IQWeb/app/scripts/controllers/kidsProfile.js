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
   this.acceptUpdate = acceptUpdate;
   this.loadRegions = loadRegions;
   this.loadCities = loadCities;
   this.start=start;
   this.getkid;
   this.getCountry;
   this.getRegions;
   this.getCity;
   this.getGrades;
   this.getSchool;

    this.edit=true;
    this.btnAcceptCancel=false;

  
    function start(){
      
      $http.get('http://localhost:3000/getKid/'+$routeParams.idkid).then(function(response){
      $scope.vm.getkid=response.data[0][0];
      });
      

    }
    
    function updateKidsForm(){
      this.edit= false;
      this.btnAcceptCancel = !this.edit;
     
      
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

      if(this.selectedCountry){
 
        $http.get('http://localhost:3000/getRegions/'+this.selectedCountry.idCountry).then(function(response){
     
           $scope.vm.getRegions=response.data[0];
        });
      }
     
    }

    function loadCities(){
      if(this.selectedRegion){

        $http.get('http://localhost:3000/getCities/'+this.selectedRegion.idRegion).then(function(response){
      
           $scope.vm.getCities=response.data[0];
        });
      }
     
    }
    
    function acceptUpdate(){
      
      this.getkid.country=this.selectedCountry.name;
      this.getkid.region=this.selectedRegion.name;
      this.getkid.city=this.selectedCity.idCity;
      this.getkid.grade=this.selectedGrade.idGrade;
      this.getkid.school=this.selectedSchool.idSchool;
      console.dir(this.getkid);
      console.dir(this.selectedCity);
      console.dir(this.selectedGrade);

      $http.post('http://localhost:3000/modKid',this.getkid).then(function(response){
        console.log(response.data);
      });
     
    }

    function cancelUpdate(){
      this.edit = true;
      this.btnAcceptCancel = !this.edit;
    }

   

  });

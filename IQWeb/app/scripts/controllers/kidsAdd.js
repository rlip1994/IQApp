'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('kidsAdd', function ($window,$scope, $http, $mdDialog, $cookieStore) {

    var vm = this;

    vm.acceptAddKid = acceptAddKid;
    vm.loadRegions = loadRegions;
    vm.loadCities = loadCities;
    vm.errorDialog = errorDialog;
    vm.start = start;


    vm.getkid;
    vm.getCountry;
    vm.getRegions;
    vm.getCity;
    vm.getGrades;
    vm.getSchool;
    vm.addKidResponse;

    function start() {
      $http.get('http://andresolis-littlestark.c9users.io:8080/getCountry/').then(function (response) {

        $scope.vm.getCountry = response.data[0];
      });

      $http.get('http://andresolis-littlestark.c9users.io:8080/getGrades/').then(function (response) {

        $scope.vm.getGrades = response.data[0];
      });

      $http.get('http://andresolis-littlestark.c9users.io:8080/getSchool/').then(function (response) {

        $scope.vm.getSchool = response.data[0];
      });
    }

    function loadRegions() {

      if (vm.selectedCountry) {

        $http.get('http://andresolis-littlestark.c9users.io:8080/getRegions/' + vm.selectedCountry.idCountry).then(function (response) {

          $scope.vm.getRegions = response.data[0];
        });
      }

    }



    function succesDialog() {
      
      $mdDialog.show(
        $mdDialog.alert()
          .clickOutsideToClose(true)
          .title('Niño Agregado')
          .textContent('Se ha agregado un(a) niño(a) de manera exitosa')
          .ariaLabel('Alert Dialog Demo')
          .ok('Aceptar')
      );
    }
  
    function errorDialog() {

            var alert = $mdDialog.alert()
                .clickOutsideToClose(true)
                .title('Error')
                .textContent('Debe llenar todos los datos que se le solicitan')
                .ariaLabel('Alert Dialog Demo')
                .ok('Aceptar');

            $mdDialog.show(alert).then(function() {
                //$window.location.reload();
            });
            
            
    }


    function loadCities() {
      if (vm.selectedRegion) {

        $http.get('http://andresolis-littlestark.c9users.io:8080/getCities/' + vm.selectedRegion.idRegion).then(function (response) {

          $scope.vm.getCities = response.data[0];
        });
      }

    }

    function acceptAddKid() {
      
        vm.getkid.idUser = $cookieStore.get('idUser');
       
      if (!angular.isUndefined(vm.getkid)) {
                if (!angular.isUndefined(vm.selectedCountry) && !angular.isUndefined(vm.selectedRegion) && !angular.isUndefined(vm.selectedCity) && 
                !angular.isUndefined(vm.selectedGrade) && !angular.isUndefined(vm.selectedSchool)) {
                    vm.getkid.country = vm.selectedCountry.name;
                    vm.getkid.region = vm.selectedRegion.name;
                    vm.getkid.city = vm.selectedCity.idCity;
                    vm.getkid.grade = vm.selectedGrade.idGrade;
                    vm.getkid.school = vm.selectedSchool.idSchool;
                  
                        $http.post('http://andresolis-littlestark.c9users.io:8080/addKid', vm.getkid).then(function (response) {
                          $scope.vm.addKidResponse = response;
                          
                            succesDialog();
                       
                            var landingUrl = "http://" + $window.location.host + "/#!/kids";
                            $window.location.href = landingUrl;
                        });

                   
                }
                else{
                  vm.errorDialog();
                }
            }


        
       
    
    }



  });

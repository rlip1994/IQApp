'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('kidsAdd', function ($window,$scope, $http, $mdDialog) {

    var vm = this;

    vm.acceptAddKid = acceptAddKid;
    vm.loadRegions = loadRegions;
    vm.loadCities = loadCities;
    vm.start = start;


    vm.getkid;
    vm.getCountry;
    vm.getRegions;
    vm.getCity;
    vm.getGrades;
    vm.getSchool;
    vm.addKidResponse;

    function start() {
      $http.get('http://localhost:3000/getCountry/').then(function (response) {

        $scope.vm.getCountry = response.data[0];
      });

      $http.get('http://localhost:3000/getGrades/').then(function (response) {

        $scope.vm.getGrades = response.data[0];
      });

      $http.get('http://localhost:3000/getSchool/').then(function (response) {

        $scope.vm.getSchool = response.data[0];
      });
    }

    function loadRegions() {

      if (vm.selectedCountry) {

        $http.get('http://localhost:3000/getRegions/' + vm.selectedCountry.idCountry).then(function (response) {

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
    };



    function loadCities() {
      if (vm.selectedRegion) {

        $http.get('http://localhost:3000/getCities/' + vm.selectedRegion.idRegion).then(function (response) {

          $scope.vm.getCities = response.data[0];
        });
      }

    }

    function acceptAddKid() {

      if (vm.getkid) {
        vm.getkid.country = vm.selectedCountry.name;
        vm.getkid.region = vm.selectedRegion.name;
        vm.getkid.city = vm.selectedCity.idCity;
        vm.getkid.grade = vm.selectedGrade.idGrade;
        vm.getkid.school = vm.selectedSchool.idSchool;
        vm.getkid.idUser = 63;


        $http.post('http://localhost:3000/addKid', vm.getkid).then(function (response) {
          $scope.vm.addKidResponse = response;
        });
        // validacion del contenido de getkid  que no sea NULL  
        succesDialog();
        var landingUrl = "http://" + $window.location.host + "/#!/kids";
        $window.location.href = landingUrl;


      }

    }



  });

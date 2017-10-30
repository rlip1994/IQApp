'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('KidsCtrl', function ($scope,$http) {
  

    var vm = this;
    
    vm.start=start;
    vm.search=search;
    vm.kids;
    vm.searchType=["Escuela","Grado","Identificacion","Region"];


    
    function start(){
      $http.get('http://andresolis-littlestark.c9users.io:8080/getAllKids/63').then(function(response){
        
        $scope.vm.kids=response.data[0];
      });
    }
    
 function search(){
      console.dir(vm.selectedSearchType);
      console.dir(vm.searchItem);
    }


  });
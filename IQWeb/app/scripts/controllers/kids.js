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
    vm.kids;
    


    
    function start(){
      $http.get('http://localhost:3000/getAllKids/63').then(function(response){
        
        $scope.vm.kids=response.data[0];
      });

    }
    
    function cancelUpdate(){
      
    }



  });
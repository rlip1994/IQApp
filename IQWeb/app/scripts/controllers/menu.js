'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('menu', function($scope, $http,$cookieStore,$location) {


    var vm = this;
    
    vm.logout= logout;
    //vm.getAdmin= getAdmin;
    vm.isIn;
    vm.isAdmin;
    vm.start=start;
    
    function start(){
        if(angular.isUndefined($cookieStore.get('idUser'))){
            vm.isIn = false;
        }else{
            vm.isIn = true;
        }
        
        getAdmin();
        console.dir(vm.isAdmin);
    }
    
    
    function logout(){
        angular.isUndefined($cookieStore.put('idUser',undefined));
        vm.isIn = false;
        $location.path('/login');
    }
    
    function getAdmin(){
        if(!angular.isUndefined($cookieStore.get('idUser'))){
            return $http.get('http://andresolis-littlestark.c9users.io:8080/getType/'+$cookieStore.get('idUser')).then(function (response) {
                if (response.data[0][0].name === 'Administrador'){
                    $cookieStore.put('isAdmin',true);
                    vm.isAdmin = true;
                }
                else{
                    $cookieStore.put('isAdmin',false);
                    vm.isAdmin = false;
                }
            });
        }
        
    }

   


  });

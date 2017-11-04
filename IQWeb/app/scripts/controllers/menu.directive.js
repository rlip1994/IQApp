
'use strict';

angular.module('iqwebApp').directive('menu', menu );




function menu () {
    
    var directive = {
            restrict: 'E',
            templateUrl: 'views/menu.html',
            controller: 'menu',
            controllerAs: 'vm',
            bindToController: true
        };
        return directive;
}
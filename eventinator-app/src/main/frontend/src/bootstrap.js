'use strict';
angular.element(document).ready(function(){
    angular.bootstrap(document, [
        'ui.router',
        'ngResource',
        'ui.bootstrap',
        'ui.calendar',
        'ngMessages',
        'ngTagsInput',
        'app',
        'app.dashboard'
    ]);
});
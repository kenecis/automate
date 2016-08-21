'use strict';
module.exports = [
    '$resource',
    function ($resource) {
        return $resource('/api/:api', {}, {
            submit: {
                method: 'POST'
            }
        });
    }
];
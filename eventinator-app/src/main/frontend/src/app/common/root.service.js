'use strict';
module.exports = [
    '$resource',
    function ($resource) {
        return $resource('/api/:api', {}, {
            logout: {
                params: {
                    api: 'logout'
                },
                method: 'POST'
            },
            principal: {
                params: {
                    api: 'user'
                },
                method: 'GET'
            }
        });
    }
];
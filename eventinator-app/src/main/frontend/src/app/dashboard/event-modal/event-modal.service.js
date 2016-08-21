'use strict';
module.exports = [
    '$resource',
    function ($resource) {
        return $resource('/api/:api', {}, {
            submit: {
                params: {
                    api: 'event/save'
                },
                method: 'POST'
            },
            interests: {
                params: {
                    api: 'interests'
                },
                method: 'GET',
                isArray: true
            }
        });
    }
];
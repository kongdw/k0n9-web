var TableTree = function() {

    var demo1 = function() {

        jQuery('#gtreetable').gtreetable({
            'source': function (id) {
                return {
                    type: 'GET',
                    url: WEB_ROOT +'/a/sys/area/list',
                    data: { 'id': id },
                    dataType: 'json',
                    error: function(XMLHttpRequest) {
                        alert(XMLHttpRequest.status+': '+XMLHttpRequest.responseText);
                    }
                }
            },
            'onSave':function (oNode) {
                return {
                    type: 'POST',
                    url: !oNode.isSaved() ? 'nodeCreate' : 'nodeUpdate?id=' + oNode.getId(),
                    data: {
                        parent: oNode.getParent(),
                        name: oNode.getName(),
                        position: oNode.getInsertPosition(),
                        related: oNode.getRelatedNodeId()
                    },
                    dataType: 'json',
                    error: function(XMLHttpRequest) {
                        alert(XMLHttpRequest.status+': '+XMLHttpRequest.responseText);
                    }
                };
            },
            'onDelete':function (oNode) {
                return {
                    type: 'POST',
                    url: 'nodeDelete?id=' + oNode.getId(),
                    dataType: 'json',
                    error: function(XMLHttpRequest) {
                        alert(XMLHttpRequest.status+': '+XMLHttpRequest.responseText);
                    }
                };
            }
        });
    }

    return {

        //main function to initiate the module
        init: function() {

            demo1();
        }

    };

}();
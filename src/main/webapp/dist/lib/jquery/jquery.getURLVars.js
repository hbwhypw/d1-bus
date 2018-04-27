//url variable reader
$.extend({
    getUrlVars: function () {
        var vars = [], hash;
        var query = window.location.href.slice(window.location.href.indexOf('?') + 1);
        //处理?q=0s2Ufu#mainPanel
        var index = query.indexOf('#') == -1 ? query.length+1 : query.indexOf('#');
        var hashes = query.substring(0,index).split('&');
        for (var i = 0; i < hashes.length; i++) {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    },
    getUrlVar: function (name) {
        return decodeURIComponent($.getUrlVars()[name]);
    }
});

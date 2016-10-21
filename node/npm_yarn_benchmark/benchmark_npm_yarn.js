var rmdir = require('rmdir'),
    exec = require('child_process').exec;

rmAndInstall('yarn');
rmAndInstall('npm');
rmAndInstall('npm', '--cache-min 9999999');

function rmAndInstall(libName, options) {
    rmdir("node_modules", () => {
        const init = new Date();
        const opts = options === undefined ? '' : options
        console.log('Executing '+libName+' ' +opts+' install');
        exec(libName+' ' +opts+' install', (error, stdout, stderr) => {
            console.log(libName+' '+opts+' took: '+ (new Date() - init).toString());
        });
    });
}
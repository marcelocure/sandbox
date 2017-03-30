# If you come from bash you might have to change your $PATH.
# export PATH=$HOME/bin:/usr/local/bin:$PATH

# Path to your oh-my-zsh installation.
export ZSH=/home/marcelocure/.oh-my-zsh
export JAVA_HOME="/usr/lib/jvm/java-8-oracle/"
export USE_MQ="true"
alias build="docker-compose build ; docker-compose up"
alias up="docker-compose -f docker-compose-local.yml up -d"
alias vpn='(echo -e "t00thbrush@2017" & cat) | sudo openconnect navpn.agcocorp.com -u "curem" --passwd-on-stdin'
alias fuse-log='function _parseLog(){ zcat $1 | sed -r "s/.*line\":(.*),\"host.*/\1/" | bunyan | subl - ;};_parseLog'
alias run-tests='docker-compose build ; docker-compose up'
alias kill-containers='docker kill $(docker ps -a -q) ; docker rm $(docker ps -a -q)'
alias restart-api-qa='heroku ps:scale web=0 -a fuse-features-api-qa ; sleep 5 ; heroku ps:scale web=1 -a fuse-features-api-qa'
ZSH_THEME="robbyrussell"

plugins=(git)

source $ZSH/oh-my-zsh.sh

export SDKMAN_DIR="/home/marcelocure/.sdkman"
[[ -s "/home/marcelocure/.sdkman/bin/sdkman-init.sh" ]] && source "/home/marcelocure/.sdkman/bin/sdkman-init.sh"

export N_PREFIX="$HOME/n"; [[ :$PATH: == *":$N_PREFIX/bin:"* ]] || PATH+=":$N_PREFIX/bin"  # Added by n-install (see http://git.io/n-install-repo).

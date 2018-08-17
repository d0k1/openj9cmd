# OpenJ9 Diagnostic tool
OpenJ9 doesn't have any command line diagnostic utilities like jstack / jmap / jstat / jcmd.
It is because OpenJ9 does not have Attach API extensions as OpenJDK have at the moment.
This project demonstrates abilities of Attach API in OpenJ9 that are added with https://github.com/eclipse/openj9/issues/2543

## Example

You cant wrap this tool into shell script, for example openj9cmd.sh

`
${JAVA_HOME}/bin/java -classpath ${JAVA_HOME}/jre/lib/charsets.jar:${JAVA_HOME}/jre/lib/ext/cldrdata.jar:${JAVA_HOME}/jre/lib/ext/dnsns.jar:${JAVA_HOME}/jre/lib/ext/dtfj.jar:${JAVA_HOME}/jre/lib/ext/dtfjview.jar:${JAVA_HOME}/jre/lib/ext/jaccess.jar:${JAVA_HOME}/jre/lib/ext/localedata.jar:${JAVA_HOME}/jre/lib/ext/nashorn.jar:${JAVA_HOME}/jre/lib/ext/sunec.jar:${JAVA_HOME}/jre/lib/ext/sunjce_provider.jar:${JAVA_HOME}/jre/lib/ext/sunpkcs11.jar:${JAVA_HOME}/jre/lib/ext/traceformat.jar:${JAVA_HOME}/jre/lib/ext/zipfs.jar:${JAVA_HOME}/jre/lib/jce.jar:${JAVA_HOME}/jre/lib/jsse.jar:${JAVA_HOME}/jre/lib/management-agent.jar:${JAVA_HOME}/jre/lib/resources.jar:${JAVA_HOME}/jre/lib/rt.jar:${JAVA_HOME}/lib/tools.jar:./target/openj9cmd-1.0-SNAPSHOT.jar com.focusit.openj9cmd "$@"
`

later you can call it
```
bash ./openj9cmd.sh 31605 threaddump /tmp/threaddump
bash ./openj9cmd.sh 31605 jstack true true jstack.txt
```
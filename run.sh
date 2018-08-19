#!/usr/bin/env bash
JAVA_HOME=~/openj9

${JAVA_HOME}/bin/java -classpath ${JAVA_HOME}/jre/lib/charsets.jar:${JAVA_HOME}/jre/lib/ext/cldrdata.jar:${JAVA_HOME}/jre/lib/ext/dnsns.jar:${JAVA_HOME}/jre/lib/ext/dtfj.jar:${JAVA_HOME}/jre/lib/ext/dtfjview.jar:${JAVA_HOME}/jre/lib/ext/jaccess.jar:${JAVA_HOME}/jre/lib/ext/localedata.jar:${JAVA_HOME}/jre/lib/ext/nashorn.jar:${JAVA_HOME}/jre/lib/ext/sunec.jar:${JAVA_HOME}/jre/lib/ext/sunjce_provider.jar:${JAVA_HOME}/jre/lib/ext/sunpkcs11.jar:${JAVA_HOME}/jre/lib/ext/traceformat.jar:${JAVA_HOME}/jre/lib/ext/zipfs.jar:${JAVA_HOME}/jre/lib/jce.jar:${JAVA_HOME}/jre/lib/jsse.jar:${JAVA_HOME}/jre/lib/management-agent.jar:${JAVA_HOME}/jre/lib/resources.jar:${JAVA_HOME}/jre/lib/rt.jar:${JAVA_HOME}/lib/tools.jar:./target/openj9cmd-1.0.jar com.focusit.openj9cmd "$@"

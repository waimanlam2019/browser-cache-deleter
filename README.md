This is a mini project used to delete cache from browsers in order to allow external control over the cache data.

With the assumption that the cache folder won't be changed frequently, the program could delete cache external after examining that the last modified date has at least 5 minutes old ( or any other configuration )

The program was developed in mac and tested on mac. Test on windows would be arranged later.

How to use (Mac/Linux):
1. Download the jar "browser-cache-deleter-<VERSION>-SNAPSHOT-jar-with-dependencies.jar" and use one of the shell scripts in "scripts" folder.
2. modify mac-run-cache-deleter.sh to reflect the downloaded jar location
3. Open a terminal shell
4. Execute command "chmod +x mac-run-cache-deleter.sh"
5. Execute command "sh mac-run-cache-deleter.sh"
6. (Optional) step 6 could be arranged in a task scheduler such as launchctl

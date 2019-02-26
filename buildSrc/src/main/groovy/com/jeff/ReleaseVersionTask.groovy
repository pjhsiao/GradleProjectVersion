package com.jeff

import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.DefaultTask;

class ReleaseVersionTask extends DefaultTask {
    @Input Boolean release
    @OutputFile File destFile

    ReleaseVersionTask() {
        group = 'versioning'
        description = 'Makes project a release version.'
    }

    @TaskAction
    void start() {
        ant.propertyfile(file: destFile) {
            entry(key: 'release', type: 'string', operation: '=', value: release)
        }
		
		logger.quiet "release:$release"
    }
}
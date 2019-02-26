package com.jeff

import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask
// The task which be use to define how increase verison number  
class IncrementingVersionTask extends DefaultTask {
	ProjectVersion currentVersion
	Object destFile
	String incrementField
	IncrementingVersionTask() {
		group = 'versioning'
		description = 'Incrementing version of project.'
	}

	@TaskAction
	void start() {
		
		ant.propertyfile(file: destFile) {
				entry(key: "$incrementField", type: 'int', operation: '+', value: 1)
			}
		int afterMajVersion = currentVersion.maj
		int afterMinVersion = currentVersion.min;
		if(incrementField.equals("major")){
			afterMajVersion++
		}else{
			afterMinVersion++
		}
		
		logger.quiet "Incremented $currentVersion.maj.$currentVersion.min -> $afterMajVersion.$afterMinVersion"
	}
}
package com.jeff


class ProjectVersion {
    Integer min
    Integer maj
    Boolean prodReady

    @Override
    String toString() {
        "$maj.$min${prodReady ? '' : '-SNAPSHOT-Jeff'}"
    }
}
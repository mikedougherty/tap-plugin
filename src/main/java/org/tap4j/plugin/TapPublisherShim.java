package org.tap4j.plugin;

import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Run;
import hudson.model.TaskListener;
import jenkins.tasks.SimpleBuildStep;

public class TapPublisherShim extends TapPublisher implements SimpleBuildStep {
    @Deprecated
    public TapPublisherShim(String testResults,
            Boolean failIfNoResults,
            Boolean failedTestsMarkBuildAsFailure,
            Boolean outputTapToConsole,
            Boolean enableSubtests,
            Boolean discardOldReports,
            Boolean todoIsFailure,
            Boolean includeCommentDiagnostics,
            Boolean validateNumberOfTests,
            Boolean planRequired,
            Boolean verbose) {

        super(
            testResults,
            failIfNoResults,
            failedTestsMarkBuildAsFailure,
            outputTapToConsole,
            enableSubtests,
            discardOldReports,
            todoIsFailure,
            includeCommentDiagnostics,
            validateNumberOfTests,
            planRequired,
            verbose
        );
    }

    @DataBoundConstructor
    public TapPublisherShim(String testResults,
            Boolean failIfNoResults,
            Boolean failedTestsMarkBuildAsFailure,
            Boolean outputTapToConsole,
            Boolean enableSubtests,
            Boolean discardOldReports,
            Boolean todoIsFailure,
            Boolean includeCommentDiagnostics,
            Boolean validateNumberOfTests,
            Boolean planRequired,
            Boolean verbose,
            Boolean showOnlyFailures) {

        super(
            testResults,
            failIfNoResults,
            failedTestsMarkBuildAsFailure,
            outputTapToConsole,
            enableSubtests,
            discardOldReports,
            todoIsFailure,
            includeCommentDiagnostics,
            validateNumberOfTests,
            planRequired,
            verbose,
            showOnlyFailures
        );
    }

    @Override
    public void perform(Run<?,?> build, FilePath workspace, Launcher launcher,
            TaskListener listener) throws InterruptedException, IOException {

        perform((AbstractBuild<?, ?>) build, launcher, (BuildListener) listener);
    }
}

package com.example.sprintboot_test;

import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class AutoUpdater {

    public static void main(String[] args) throws URISyntaxException {
        String projectPath = "D:\\springboot_test";
        String remoteUrl = "https://github.com/your/repo.git";
        String buildCommand = "mvn clean package";
        String jarLocation = "/path/to/target/folder/yourapp.jar";
        String deploymentLocation = "/path/to/deployment/folder/yourapp.jar";
        // 1. 更新代码
        updateFromGit(projectPath, remoteUrl);
        // 2. 构建项目
        buildProject(projectPath, buildCommand);
        // 3. 替换jar包
        replaceJar(jarLocation, deploymentLocation);
        // 4. 重启应用 (视应用需求而定)
        restartApplication();
    }

    public static void updateFromGit(String localPath, String remoteUrl) {
        try {
            File gitDir = new File(localPath);
            if (gitDir.exists()) {
                try (Git git = Git.open(gitDir)) {
                    git.pull().call();
                }
            } else {
                Git.cloneRepository()
                    .setURI(remoteUrl)
                    .setDirectory(gitDir)
                    .call();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buildProject(String projectPath, String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", command);
            processBuilder.directory(new File(projectPath));
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replaceJar(String source, String target) {
        try {
            Files.copy(Paths.get(source), Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void restartApplication() throws URISyntaxException {
        String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        File currentJar = new File(AutoUpdater.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        /* is it a jar file? */
        if(!currentJar.getName().endsWith(".jar")) {
            return;
        }

        /* Build command: java -jar application.jar */
        List<String> command = new ArrayList<>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

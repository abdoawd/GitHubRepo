package com.example.abdulrahman.githubrepo.entity;

public class Repo {
    private String has_issues;

    private String teams_url;

    private String compare_url;

    private String releases_url;

    private String keys_url;

    private String has_pages;

    private String description;

    private String milestones_url;

    private String has_wiki;

    private String events_url;

    private String archive_url;

    private String subscribers_url;

    private String contributors_url;

    private String pushed_at;

    private String fork;

    private String svn_url;

    private String collaborators_url;

    private String subscription_url;

    private String clone_url;

    private String trees_url;


    private String url;

    private String size;

    private String notifications_url;

    private String deployments_url;

    private String updated_at;

    private String branches_url;

    private Owner owner;

    private String issue_events_url;

    private String language;

    private String forks_count;

    private String contents_url;

    private String watchers_count;

    private String blobs_url;

    private String commits_url;

    private String has_downloads;

    private String git_commits_url;

    private String node_id;


    private String default_branch;

    private String open_issues;

    private String id;

    private String downloads_url;


    private String has_projects;

    private String archived;

    private String comments_url;

    private String name;

    private String created_at;

    private String stargazers_count;

    private String assignees_url;

    private License license;

    private String pulls_url;

    private String watchers;

    private String stargazers_url;

    private String hooks_url;

    private String languages_url;

    private String issues_url;

    private String git_tags_url;

    private String merges_url;

    private String git_refs_url;

    private String open_issues_count;

    private String ssh_url;

    private String html_url;

    private String forks;

    private String forks_url;

    private String statuses_url;

    private String issue_comment_url;

    private String labels_url;

    private String git_url;

    private String tags_url;

    private String full_name;

    public Repo(String has_issues, String teams_url, String compare_url, String releases_url, String keys_url, String has_pages,
                String description, String milestones_url, String has_wiki, String events_url, String archive_url,
                String subscribers_url, String contributors_url, String pushed_at, String fork, String svn_url,
                String collaborators_url, String subscription_url, String clone_url, String trees_url, String url,
                String size, String notifications_url, String deployments_url, String updated_at, String branches_url,
                Owner owner, String issue_events_url, String language, String forks_count, String contents_url,
                String watchers_count, String blobs_url, String commits_url, String has_downloads, String git_commits_url,
                String node_id, String default_branch, String open_issues, String id, String downloads_url, String has_projects,
                String archived, String comments_url, String name, String created_at, String stargazers_count,
                String assignees_url, License license, String pulls_url, String watchers, String stargazers_url, String hooks_url,
                String languages_url, String issues_url, String git_tags_url, String merges_url, String git_refs_url,
                String open_issues_count, String ssh_url, String html_url, String forks, String forks_url, String statuses_url,
                String issue_comment_url,
                String labels_url, String git_url, String tags_url, String full_name) {
        this.has_issues = has_issues;
        this.teams_url = teams_url;
        this.compare_url = compare_url;
        this.releases_url = releases_url;
        this.keys_url = keys_url;
        this.has_pages = has_pages;
        this.description = description;
        this.milestones_url = milestones_url;
        this.has_wiki = has_wiki;
        this.events_url = events_url;
        this.archive_url = archive_url;
        this.subscribers_url = subscribers_url;
        this.contributors_url = contributors_url;
        this.pushed_at = pushed_at;
        this.fork = fork;
        this.svn_url = svn_url;
        this.collaborators_url = collaborators_url;
        this.subscription_url = subscription_url;
        this.clone_url = clone_url;
        this.trees_url = trees_url;
        this.url = url;
        this.size = size;
        this.notifications_url = notifications_url;
        this.deployments_url = deployments_url;
        this.updated_at = updated_at;
        this.branches_url = branches_url;
        this.owner = owner;
        this.issue_events_url = issue_events_url;
        this.language = language;
        this.forks_count = forks_count;
        this.contents_url = contents_url;
        this.watchers_count = watchers_count;
        this.blobs_url = blobs_url;
        this.commits_url = commits_url;
        this.has_downloads = has_downloads;
        this.git_commits_url = git_commits_url;
        this.node_id = node_id;
        this.default_branch = default_branch;
        this.open_issues = open_issues;
        this.id = id;
        this.downloads_url = downloads_url;
        this.has_projects = has_projects;
        this.archived = archived;
        this.comments_url = comments_url;
        this.name = name;
        this.created_at = created_at;
        this.stargazers_count = stargazers_count;
        this.assignees_url = assignees_url;
        this.license = license;
        this.pulls_url = pulls_url;
        this.watchers = watchers;
        this.stargazers_url = stargazers_url;
        this.hooks_url = hooks_url;
        this.languages_url = languages_url;
        this.issues_url = issues_url;
        this.git_tags_url = git_tags_url;
        this.merges_url = merges_url;
        this.git_refs_url = git_refs_url;
        this.open_issues_count = open_issues_count;
        this.ssh_url = ssh_url;
        this.html_url = html_url;
        this.forks = forks;
        this.forks_url = forks_url;
        this.statuses_url = statuses_url;
        this.issue_comment_url = issue_comment_url;
        this.labels_url = labels_url;
        this.git_url = git_url;
        this.tags_url = tags_url;
        this.full_name = full_name;
    }


    public String getHas_issues() {
        return has_issues;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public String getCompare_url() {
        return compare_url;
    }

    public String getReleases_url() {
        return releases_url;
    }

    public String getKeys_url() {
        return keys_url;
    }

    public String getHas_pages() {
        return has_pages;
    }

    public String getDescription() {
        return description;
    }

    public String getMilestones_url() {
        return milestones_url;
    }

    public String getHas_wiki() {
        return has_wiki;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getArchive_url() {
        return archive_url;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public String getContributors_url() {
        return contributors_url;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public String getFork() {
        return fork;
    }

    public String getSvn_url() {
        return svn_url;
    }

    public String getCollaborators_url() {
        return collaborators_url;
    }

    public String getSubscription_url() {
        return subscription_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public String getTrees_url() {
        return trees_url;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }

    public String getNotifications_url() {
        return notifications_url;
    }

    public String getDeployments_url() {
        return deployments_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getIssue_events_url() {
        return issue_events_url;
    }

    public String getLanguage() {
        return language;
    }

    public String getForks_count() {
        return forks_count;
    }

    public String getContents_url() {
        return contents_url;
    }

    public String getWatchers_count() {
        return watchers_count;
    }

    public String getBlobs_url() {
        return blobs_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public String getHas_downloads() {
        return has_downloads;
    }

    public String getGit_commits_url() {
        return git_commits_url;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public String getOpen_issues() {
        return open_issues;
    }

    public String getId() {
        return id;
    }

    public String getDownloads_url() {
        return downloads_url;
    }

    public String getHas_projects() {
        return has_projects;
    }

    public String getArchived() {
        return archived;
    }

    public String getComments_url() {
        return comments_url;
    }

    public String getName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getStargazers_count() {
        return stargazers_count;
    }

    public String getAssignees_url() {
        return assignees_url;
    }

    public License getLicense() {
        return license;
    }

    public String getPulls_url() {
        return pulls_url;
    }

    public String getWatchers() {
        return watchers;
    }

    public String getStargazers_url() {
        return stargazers_url;
    }

    public String getHooks_url() {
        return hooks_url;
    }

    public String getLanguages_url() {
        return languages_url;
    }

    public String getIssues_url() {
        return issues_url;
    }

    public String getGit_tags_url() {
        return git_tags_url;
    }

    public String getMerges_url() {
        return merges_url;
    }

    public String getGit_refs_url() {
        return git_refs_url;
    }

    public String getOpen_issues_count() {
        return open_issues_count;
    }

    public String getSsh_url() {
        return ssh_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getForks() {
        return forks;
    }

    public String getForks_url() {
        return forks_url;
    }

    public String getStatuses_url() {
        return statuses_url;
    }

    public String getIssue_comment_url() {
        return issue_comment_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public String getGit_url() {
        return git_url;
    }

    public String getTags_url() {
        return tags_url;
    }

    public String getFull_name() {
        return full_name;
    }
}

# Java Message Service Specification
{: .no_toc}

Welcome to the website for the development of the Java Message Service (JMS) specification.

## Contents
{: .no_toc}

* auto-gen TOC:
{:toc}

## Latest news (June 2017)

The JMS specification has moved to GitHub and groups.io from its old home on java.net!
* The website is here, [https://javaee.github.io/jms-spec/](https://javaee.github.io/jms-spec/).
* The source code repository is at [https://github.com/javaee/jms-spec] and uses Git. This contains the API and specification source.
* The issue tracker is at [https://github.com/javaee/jms-spec/issues](https://github.com/javaee/jms-spec/issues)
* The user mailing list is on groups.io at [https://javaee.groups.io/g/jms-spec](https://javaee.groups.io/g/jms-spec) 

## JMS 2.1 (now withdrawn)

[JSR 368](https://jcp.org/en/jsr/detail?id=368) was withdrawn in November 2016.
See the [main JMS 2.1 page](/jms-spec/pages/JMS21).

## JMS 2.0 errata

An errata for JMS 2.0 was released in March 2015. This is now the latest release of JMS. See the [JMS 2.0 errata page](/jms-spec/pages/JMS20RevA).

## JMS 2.0

JMS 2.0 is the latest released version of JMS and  was released on 21 May 2013. 
See the [JMS 2.0 Final Release page](/jms-spec/pages/JMS20FinalRelease). 

## About the development of the JMS specification

The Java Message Service (JMS) specification was first released in 1998, at the dawn of Java EE, with a major update in 2002. It then remained unchanged during the decade that followed. Meanwhile, technology evolved and many vendors pressed ahead with enhancements outside the specification. During that time, the rest of Java EE evolved significantly, with improvements and new features added. Despite the lack of development of the specification, JMS continued to be a popular and successful standard, with numerous competing implementations, both standalone and as part of complete Java EE stacks, and  open and closed source. 

On 1st March 2011 a Java Specification Request (JSR) was submitted to the [Java Community Process](http://jcp.org/en/home/index) which proposed the development of JMS 2.0. This is [JSR 343](http://jcp.org/en/jsr/detail?id=343).  

On 21 May 2013 JMS 2.0 was released. This major update introduces a new simplified API and adds support for the injection of JMS connections into Java EE applications. It forms part of Java EE 7. Now that JMS 2.0 is released, JSR 343 moves into maintenance mode.

In August 2014 a new Java Specification Request (JSR) was submitted to the [Java Community Process](http://jcp.org/en/home/index) which proposed the development of JMS 2.1.   This was [JSR 368](http://jcp.org/en/jsr/detail?id=368). Following a review of priorities at Oracle, this JSR was withdrawn in November 2016. For more information see the [main JMS 2.1 page](/jms-spec/pages/JMS21).

The purpose of this website is to support the continuing development of the JMS specification. 
by hosting their mailing lists, issue tracker, and any other resources that are required. 
It runs in conjunction with the [official JSR 343 page on the JCP website](http://jcp.org/en/jsr/detail?id=343).
which is used mainly to conduct the formal aspects of these JSRs.

The maintenance lead for JSR 343 (JMS 2.0) is [Nigel Deakin](mailto:nigel.deakin@oracle.com) (Oracle). 

## Getting involved

Here are some ways to get involved in the development of the JMS specification:

*  **Read** the [main JMS 2.1 page](/jms-spec/pages/JMS21).

* If you'd like to **contribute** to the development of the JMS specification, or simply **observe** what is going on in the expert group, join the [mailing list](mailto:users@jms-spec.java.net users@jms-spec.java.net). See below for instructions on how to join.

* If you'd like to **submit proposals** for consideration by the expert group, log them as issues in the [issue tracker](/javaee/jms-spec/issues). Please read [How to use the issue tracker](http://java.net/projects/jms-spec/pages/Home#How_to_create_an_issue). We're interested in comments on JMS 2.0 as well as proposals for JMS 2.1.

* A new expert group is being formed for JSR 368 (JMS 2.1). 
Applications to **join the JSR 368 expert group** are now invited. 
See [Joining the JMS expert group](JMSExperts#Joining_the_JMS_expert_group).

* JSR 343 (JMS 2.0)  is now in maintenance mode and is administered directly by the maintenance lead. 

## JMS community mailing lists

###   Mailing lists open to everyone

Email address | Purpose | Access
:------------ | :------------- | :-------------
**jms-spec@javaee.groups.io** | Mailing list for general discussion about the JMS specification. <br><br>Everyone is welcome to join.<br><br>This list can also be used to raise issues with, or participate in discussions with, the spec lead and the expert group, if there is one in operation. | Sign up (and view the archive of past messages) at [https://javaee.groups.io/g/jms-spec](https://javaee.groups.io/g/jms-spec).
  **users@jms-spec.java.net** | Mailing list for general discussion about the JMS specification, including JMS 2.0 and JMS 2.1. Everyone is welcome to join. <br><br>This list can also be used to raise issues with, or participate in discussions with, the spec lead and expert group. All members of the expert group are expected to subscribe to this list. <br><br>Discussions on the **jsr-368-experts@jms-spec.java.net** mailing list are forwarded to this list to allow other members of the community to monitor the discussions of the expert group. Members of the community are welcome to join in on these discussions, but they'll need to send their replies to this list rather than directly to the expert group. | Anyone may send email to this list. Messages from non-subscribers are moderated (to prevent spam) so there may be a delay. <br><br>To receive messages from this list, you need to "join" the [jms-spec.java.net](http://jms-spec.java.net) project and then subscribe to this list.  ([How to do this](/jms-spec/#mailing-lists-faq).  Messages from subscribers are not moderated. <br><br>[Online archive of past messages](http://java.net/projects/jms-spec/lists/users/archive).  

###   Mailing lists FAQ
How do I join the [jms-spec.java.net](http://jms-spec.java.net) project? 
: Simply click on [Join this project](https://java.net/projects/jms-spec/watch) on the left, and you'll be instantly become a member. 
This is sometimes referred to as an "observer role". You'll need to be logged into [java.net](http://java.net). 
This will also add this project to your [My Projects](http://java.net/mypage) page.

How to I subscribe to a mailing list?
: After joining the project, navigate to (http://java.net/projects/jms-spec/lists java.net/projects/jms-spec/lists), find the list you want to subscribe to, and press the Subscribe button.  

I tried to reply to an email but it was rejected. Why?
: If you subscribe to users@jms-spec.java.net you'll automatically receive a copy of all emails sent to the expert group.  You're welcome to reply to any email with a comment. However if you are not a member of the expert group you'll need to change the recipient to users@jms-spec.java.net before replying, otherwise your email will be rejected. The expert group will see all emails sent to users@jms-spec.java.net.

###   Observer mailing list (not used) 

Email address | Purpose | Access
:------------ | :------ | :-----
  **jsr-368-observers@jcp.org** | Legacy mailing list for observers of JSR 368. <br /><br /> Being an "observer" of a JSR is an obsolete concept and although this mailing list does exist it is not used. <br /><br /> If you wish to observe what is going on with JSR 368, join the join the **users@jms-spec.java.net** mailing list using the instructions above. | Registered observers of [JSR 368](http://jcp.org/en/jsr/summary?id=368) are automatically subscribed to this list.  However being an "observer" of a JSR is an obsolete concept and applications to be observers will not be accepted. <br /><br />There is currently no online archive of past messages.

## JMS expert group mailing lists

There are two mailing lists that only JMS expert group members may subscribe. These are described in [JMS expert group mailing lists](JMSExperts#JMS_expert_group_mailing_lists).


## Issue tracker

Comments and changes to the JMS specification will be managed using [the JMS issue tracker](https://github.com/javaee/jms-spec/issues).

If you would like to propose a change to the JMS specification, please create an issue containing a description of the proposed change, or find an existing issue and add a comment.  You need to sign up for a free GitHub account and login first. 

Issues that are received will be reviewed and added to the [JMS Planning Long List](/jms-spec/pages/JMSLongList).

###  How to create an issue

Here are some guidelines to follow when creating a new issue:
* Please don't combine unrelated subjects in the same issue. Create a separate issue for each. 
* **Issue Type**: .Choose one of Bug, New Feature, Task or Improvement from the pop-up menu. 
  * Bug: There is a problem or error in the spec, API or javadocs
  * New Feature: Use this to suggest a new feature which is not in the existing spec, API or javadocs
  * Task: Please don't use this  git push origin gh-pages
  * Improvement:  An improvement or enhancement to an existing feature of the spec, API or javadocs
* **Summary** Please enter a meaningful one-line summary of your issue
* **Priority**: Please don't change this
* **Component/s** We will use this in the future to allow you to categorise your issue
* **Affects version/s** Please specify which version of the JMS specification your comment relates to. Normally this will be 1.1, the latest released version.
* Environment: Please leave blank
* **Description**: Please describe your issue in as much detail as you wish. You can add comments later.
* Original Estimate: Please leave blank
* **Attachment**: There shouldn't be much need to use this, but if necessary you can upload files here
* **Issuezilla Id**: Please leave blank
* **Status Whiteboard**: Please leave blank. We may start using this field in the future.
* **Tags**: Please leave blank. These should only be set by the project administrators, so if you set these yourself you'll confuse things. 

## Procedures and policies

The [Java EE Backwards Compatibility Requirements](https://javaee.github.io/j## Related pages
avaee-spec/CompatibilityRequirements) (on the Java EE Platform Specification website) describe the requirements to make releases of JMS 2.0  backwards compatible with previous versions.

## Important legal statements

* By contributing to this project, you are agreeing to the terms of use described in [CONTRIBUTING.md](./CONTRIBUTING.md)

* [Safe harbor statement](/jms-spec/pages/SafeHarborStatement).

## How to get involved in JMS 2.1 

### Send an email

If you would like to comment on the JSR, please do so by sending an email either to the JMS community mailing list [users@jms-spec.java.net](mailto:users@jms-spec.java.net). Before you can post messages to this list you need to join the [jms-spec.java.net](http://jms-spec.java.net) project as an observer and then subscribe to this list. For more information about JMS mailing lists see [JMS community mailing lists](/jms-spec/#jms-community-mailing-lists). 

If you prefer you can send email directly to  [Nigel Deakin](mailto:nigel.deakin@oracle.com). Please note that your comments may be forwarded to  [users@jms-spec.java.net](mailto:users@jms-spec.java.net).

### Join the community alias

Even if you don't have anything to contribute at this stage, you can join the JMS community mailing list [users@jms-spec.java.net](mailto:users@jms-spec.java.net) and see what is going on.  See [JMS community mailing lists](/jms-spec/#jms-community-mailing-lists). 

### Join the JSR 368 expert group 

Applications to join the JSR 368 expert group are now invited. Please use the form at [https://jcp.org/en/jsr/egnom?id=368](https://jcp.org/en/jsr/egnom?id=368).
The application process is described in detail in [How to join the JSR 368 expert group](/jms-spec/pages/HowToJoinTheJSR368ExpertGroup).

All applications, and the decision for any rejection, are recorded on the [JSR 368 expert group nominations](/jms-spec/pages/JSR368EGNominations) page. 

Members of the JSR 343 expert group are invited to make a new application to join the JSR 368 expert group. 

### Log an issue or comment on an existing issue

If there's a feature, or other change to the specification, that you would like to see that isn't already mentioned in [JSR 368](https://jcp.org/en/jsr/detail?id=368), the [JMS planning long list](/jms-spec/pages/JMSLongList), or in the [JMS spec issue tracker](https://github.com/javaee/jms-spec/issues) then you are welcome to log a new issue.  Pleased read  [More information about the issue tracker](/jms-spec/#issue-tracker). We'll then add it to the [JMS planning long list](/jms-spec/pages/JMSLongList) and make sure that it is considered by the new expert group. You're welcome to comment directly on existing issues 

## Related pages

* [JMS 2.0 Final Release](/jms-spec/pages/JMS20FinalRelease)
* [JMS 2.0 Planning](/jms-spec/pages/JSR343Planning). Contains lists of issues that were resolved in JMS 2.0.
* [Ten ways in which JMS 2.0 means writing less code](/jms-spec/pages/JMS20MeansLessCode)
* [JMS 2.0 design FAQ](/jms-spec/pages/JMS20ReasonsFAQ)
* [JMS 2.0 errata release (Rev a)](/jms-spec/pages/JMS20RevA)
* [JMS 2.1](/jms-spec/pages/JMS21)

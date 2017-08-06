# Pre-work - *Todoapp*

**Todoapp** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Shubhra Mittal**

Time spent: **8** hours spent in total

## User Stories

The following **required** functionality is completed:

* [Y] User can **successfully add and remove items** from the todo list
* [Y] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [Y] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [N] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [N] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [N] Add support for completion due dates for todo items (and display within listview item)
* [N] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [N] Add support for selecting the priority of each todo item (and display in listview item)
* [N] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [N] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://media.giphy.com/media/26n6T9mEqRWFIn1S0/giphy.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** In the 8 hours of Android app developement that I spent, I find that the platofrm is logical and well architectured. Yes, there are a lot of concepts to undertsand but when one starts getting a hang of how these concepts are integrated, it is easier to visualize and code the flow. I do not have any prior mobile app development experience and hence cannot compare the platform with any other.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** To enable any user interaction, there are 2 key components.They are :
1. How the data is represented to the user i.e. the view part.
2. What data is presented to the user i.e. the data which is coming from some data source.
The adapter, in the context of Todoapp, acts as a bridge or coorinator or orchestrator bteween the above 2 components. We chose to store data in an ArrayList and represent it in form of a simple list. The changes in either were communicated to other by the adapter.

convertview indicates if an unused view can be used for rendering the current view or, if there is none of the type required, a new ones needs to be created


## Notes

Describe any challenges encountered while building the app.

1. I do not have prior app dveelopement experience. Therefore, it took me time to  understand the bigger picture.


## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
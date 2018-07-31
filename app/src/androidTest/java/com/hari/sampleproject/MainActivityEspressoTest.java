package com.hari.sampleproject;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.hari.sampleproject.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void testRecyclerViewText(){
        if (getRecyclerViewCount() > 0){
            onView(withId(R.id.recyclerView))
                    .check(matches(hasDescendant(withText("Beavers"))));
        }
    }
    @Test
    public void testRecyclerViewItemClick(){
        if (getRecyclerViewCount() > 0){
            onView(withId(R.id.recyclerView))
                    .perform(actionOnItemAtPosition(0, click()));
        }
    }

    private int getRecyclerViewCount(){
        RecyclerView recyclerView = (RecyclerView) mActivityRule.getActivity().findViewById(R.id.recyclerView);
        return recyclerView.getAdapter().getItemCount();
    }
}

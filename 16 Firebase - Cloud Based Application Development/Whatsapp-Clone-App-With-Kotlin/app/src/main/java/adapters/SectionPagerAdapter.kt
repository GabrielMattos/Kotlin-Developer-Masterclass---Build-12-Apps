package adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import fragments.ChatsFragment
import fragments.UsersFragment

class SectionPagerAdapter(fragmentManager:FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when(position)
        {
            0 -> {
                return UsersFragment()
            }

            1 -> {
                return ChatsFragment()
            }
        }

        return null!!
    }

    override fun getCount(): Int {
        return 2
    }
}
import {createSlice, PayloadAction} from "redux-starter-kit";
import {BookingLink, RecurringSpan} from "./interface";

export type LinkAction = {
    link: BookingLink;
};

export type BookMeUsernameAction = {
    name: string;
}

export type FetchBookMeUsername = {
}

export type AddBookingLink = {
    afterEventBuffer: number,
    beforeEventBuffer: number,
    endDate: string,
    expireOnBooking: boolean,
    includeTaskWithoutDuration: boolean,
    projectId: number,
    recurrences: RecurringSpan[],
    slotSpan: number,
    startDate: string,
    timezone: string,
};

export type PatchBookingLink = {
    bookingLinkId: string,
    timezone: string,
    afterEventBuffer?: number,
    beforeEventBuffer?: number,
    endDate?: string,
    expireOnBooking?: boolean,
    includeTaskWithoutDuration?: boolean,
    location?: string,
    projectId?: number,
    startDate?: string,
};

let initialState = {
    link: undefined as BookingLink | undefined,
    bookMeUsername: ''
};

const slice = createSlice({
    name: 'bookingLinks',
    initialState,
    reducers: {
        linkReceived: (state, action: PayloadAction<LinkAction>) => {
            const { link } = action.payload;
            state.link = link;
        },
        bookMeUsernameReceived: (state, action: PayloadAction<BookMeUsernameAction>) => {
            const { name } = action.payload;
            state.bookMeUsername = name;
        },
        AddBookingLink: (state, action: PayloadAction<AddBookingLink>) => state,
        PatchBookingLink: (state, action: PayloadAction<PatchBookingLink>) => state,
        GetBookMeUsername: (state, action: PayloadAction<FetchBookMeUsername>) => state,
        UpdateBookMeUsername: (state, action: PayloadAction<BookMeUsernameAction>) => state,
    }
});

export const reducer = slice.reducer;
export const actions = slice.actions;

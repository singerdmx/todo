import React, { useState } from 'react';
import { IState } from "../../store";
import { connect } from "react-redux";
import { Popconfirm, Select } from 'antd';
import { CopyOutlined } from '@ant-design/icons';

const { Option } = Select; 

type BookingLinkCloneProps = {
  onClick: (e: MouseEvent) => void,
  slotSpan: number,
  linkId: string,
  cloneBookingLink: (id: string, slotSpan: string) => void,
};

const hours = [0, 1, 2, 3, 4, 6, 8, 12, 24];

const hourOptions = hours.map(hour => <Option value={(hour).toString()} key={(hour).toString()}>{hour}</Option>);

const BookingLinkClone: React.FC<BookingLinkCloneProps> = (props) => {
  const { slotSpan, linkId, cloneBookingLink } = props;

  const defaultHour = Math.floor(slotSpan / 60);
  const defaultMin = slotSpan % 60;

  const getMinOptions = (mins: number[]) => {
    return mins.map(min => <Option value={(min).toString()} key={(min).toString()}>{min}</Option>);
  }

  const [hr, setHr] = useState(String(defaultHour));
  const [min, setMin] = useState(String(defaultMin));
  const [minOptions, setMinOptions] = useState(getMinOptions([defaultMin]));

  const newSlotSpan = Number(hr) * 60 + Number(min);

  const confirm = () => {
    return cloneBookingLink(linkId, String(newSlotSpan));
  };
  
  return (
    <Popconfirm 
      style={{width: 400}}
      title={
        <div>
          <p>Do you want to change booking duration?</p>
          <Select 
            defaultValue={String(defaultHour)}
            onChange={(value: string) => {
              setHr(value);
              switch (value) {
                case "0":
                  setMinOptions(getMinOptions([45]));
                  setMin("45");
                  break;
                case "1":
                  setMinOptions(getMinOptions([0, 30]));
                  setMin("0");
                  break;
                default:
                  setMin("0");
                  setMinOptions(getMinOptions([0]));
              }
            }}
            onClick={(e) => e.stopPropagation()}
          >
            {hourOptions}
          </Select>
          {' '}hr{' '} 
          <Select defaultValue={String(defaultMin)} value={min}
            onChange={(value: string) => setMin(value)}
            onClick={(e) => e.stopPropagation()}
          >
            {minOptions}
          </Select>
        </div>
      }
      onConfirm={confirm}
      okText="Clone"
      cancelText="Cancel"
    >
      <CopyOutlined />
    </Popconfirm>
  )
};

const mapStateToProps = (state: IState) => ({});

export default connect(mapStateToProps, {})(BookingLinkClone);
